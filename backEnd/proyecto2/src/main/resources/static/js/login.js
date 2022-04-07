$(document).ready(function(){

});

async function iniciarSesion(){

    let datos ={}

    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;


 //textnombre textapellido textmail textelefono textpassword textpasswords
 //awai = esta esperando el resultado de este llamado se tiene que poner
  //el async para indicar que esta funcion es asincronica

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const respuesta = await request.text(); //lo transforman a json

    if(respuesta == 'OK'){

        window.location.href = 'usuario.html'

    }else{

        alert("Contraseña no Valida.");

    }

}
