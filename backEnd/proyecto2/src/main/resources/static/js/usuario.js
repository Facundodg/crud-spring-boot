$(document).ready(function(){

    cargarUsuarios();

});

async function cargarUsuarios(){
 //awai = esta esperando el resultado de este llamado se tiene que poner
  //el async para indicar que esta funcion es asincronica

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json(); //lo transforman a json

  let listadoUsuarioFilas = '';

  for(let usuario of usuarios){

  console.log(usuario);

  let usuarioTabla = '<tr> <td>' + usuario.id + '</td><td>'+usuario.nombre+'</td><td>'+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td><input class="botons" type="submit" value="Eliminar"></td></tr>';

    listadoUsuarioFilas += usuarioTabla;

  }

  document.querySelector('#usuarios tbody').outerHTML = listadoUsuarioFilas;

}