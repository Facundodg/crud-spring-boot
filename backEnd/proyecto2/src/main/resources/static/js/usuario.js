$(document).ready(function(){

    cargarUsuarios();

});

async function cargarUsuarios(){
 //awai = esta esperando el resultado de este llamado se tiene que poner
  //el async para indicar que esta funcion es asincronica

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json(); //lo transforman a json


  let listadoUsuarioFilas = '';

  for(let usuario of usuarios){

   let botonEliminar = '<input onclick ="eliminarUsuario('+usuario.id+')" class="botons" type="submit" value="Eliminar">'


  console.log(usuario);

  let telefono = usuario.telefono == null ? '-' : usuario.telefono;

  let usuarioTabla = '<tr> <td>' + usuario.id + '</td><td>'+usuario.nombre+'</td><td>'+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+telefono+'</td><td>'+botonEliminar+'</td></tr>';

    listadoUsuarioFilas += usuarioTabla;

  }

  document.querySelector('#usuarios tbody').outerHTML = listadoUsuarioFilas;

}

async function eliminarUsuario(id){

  const request = await fetch('api/usuario/' + id, {
    method: 'DELETE',
    headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
    }
  });

    cargarUsuarios();

}