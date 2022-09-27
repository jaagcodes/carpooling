# carpooling
Reto Pragma Power-Up
Este monolito sirve para registrar usuarios bajo los criterios impuestos por Pragma y también para buscar usuarios según su Email
Para realizar estas dos acciones se debe consumir los siguientes servicios Rest:

Para Registrar Usuario: Método @Post
localhost:8080/usuario/registrarUsuario
Json ejemplo: 
{
    "nombre":"Cristiano",
    "apellido":"Ronaldo",
    "numeroTelefono":"1234567899",
    "direccion":"CLL 10 Sur",
    "email":"cristiano@email.com",
    "password":"QRsTpm1234*"
}

Para consultar usuario según su email: Método @Get, se debe enviar una variable en la url con el email del usuario que se desea buscar
Request: localhost:8080/usuario/encontrarUsuario/cristiano@email.com
Response: 
Json :
{
    "nombre":"Cristiano",
    "apellido":"Ronaldo",
    "numeroTelefono":"1234567899",
    "direccion":"CLL 10 Sur",
    "email":"cristiano@email.com",
    "password":"QRsTpm1234*"
}
