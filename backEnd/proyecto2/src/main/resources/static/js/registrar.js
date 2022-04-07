$(document).ready(function(){

});

async function RegistrarUsuarios(){

    let datos ={}

    datos.nombre = document.getElementById('textnombre').value;
    datos.apellido = document.getElementById('textapellido').value;
    datos.email = document.getElementById('textmail').value;
    datos.telefono = document.getElementById('textelefono').value;
    datos.password = document.getElementById('textpassword').value;

    let passwordRepetida = document.getElementById('textpasswords').value;

    if(passwordRepetida != datos.password){

        alert("La contraseña es diferente");
        return;

    }

 //textnombre textapellido textmail textelefono textpassword textpasswords
 //awai = esta esperando el resultado de este llamado se tiene que poner
  //el async para indicar que esta funcion es asincronica

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

}
