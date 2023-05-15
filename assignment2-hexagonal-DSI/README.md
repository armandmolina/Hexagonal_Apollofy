# Assignment 2: Hexagonal Architecture
## Let's refactor ApolloFy from a layered architecture

In this assignment you need to migrate the Apollofy project from a layered architecture to a Hexagonal one. In doing so you are required to:
* Organize the code into different packages: configuration, common, user (including fans), trackEntity (including likes) and djlists. 
* Create input ports in separated files, but you may want to group few when they are very closely related and tend to be CRUD operations 
* Create output ports following the previous advice
* Make sure that application services (use cases) are private classes to the package
* Make sure that input adapters use the input ports rather than the application services directly
* For use cases that create or modify objects, use a full mapping strategy. That is, use input models like the SendMoneyCommand in the buckpal example
* For simple CRUD operations you can use shortcuts: for example a output adapter (persistence) that implements a input port.

## Examples
* Example written by Tom Hombergs author of the book "Get your hands dirty on clean Architecture. **Buckpal**: https://github.com/thombergs/buckpal
+ The Tinder example in Hexagonal architecture:  https://github.com/DSI-Tecnocampus/TinderHexagonal22_23. This a very close to what you need to do for this assignement.

------------------------------EN ESPAÑOL-----------------------------

## Refactorizar Apollofy desde arquitectura por capas
En esta tarea, debe migrar el proyecto Apollofy de una arquitectura en capas a una Hexagonal. Al hacerlo, usted está obligado a:
* Organice el código en diferentes paquetes: configuración, común, usuario (incluidos los fanáticos), seguimiento (incluidos los me gusta) y listas de dj.
* Cree puertos de entrada en archivos separados, pero es posible que desee agrupar algunos cuando estén muy relacionados y tiendan a ser operaciones CRUD
* Crear puertos de salida siguiendo los consejos anteriores
* Asegúrese de que los servicios de aplicación (casos de uso) sean clases privadas para el paquete
* Asegúrese de que los adaptadores de entrada usen los puertos de entrada en lugar de los servicios de la aplicación directamente
* Para casos de uso que crean o modifican objetos, use una estrategia de mapeo completa. Es decir, use modelos de entrada como SendMoneyCommand en el ejemplo de buckpal
* Para operaciones CRUD simples, puede usar atajos: por ejemplo, un adaptador de salida (persistencia) que implementa un puerto de entrada.

## Ejemplos
* Ejemplo escrito por Tom Hombergs autor del libro "Ensuciarse las manos con la arquitectura limpia. **Buckpal**: https://github.com/thombergs/buckpal
+ El ejemplo de Tinder en arquitectura Hexagonal: https://github.com/DSI-Tecnocampus/TinderHexagonal22_23. Esto es muy parecido a lo que debe hacer para esta asignación.
