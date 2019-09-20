## Ejercicio de aplicacion de patrones de diseño

* Felipe Nariño 20192099036
* Jorge Atuesta 20192099025

En esta ejercicio se aplicaron los patrones  de diseño :

* Pool de objetos (Caja), utilizando un singleton para crearlos
* Chain of Responsibility, Cada pool de cajas puede realizar una transaccion especifica, si no la puede hacer la pasa al siguiente poll
* Facade, para que el cliente con su transaccion pueda ingresar al primer eslabon de la cadena de responsabilidad
* Observer, se notificara al manejador de transacciones cuando una caja sea liberada para que pueda realizar la transaccion
