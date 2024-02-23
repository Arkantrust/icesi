**SEGUIMIENTO**

**TESTING LISTAS**

Durante la última semana en el curso hemos desarrollado el primer acercamiento a las listas enlazadas, en este seguimiento usted deberá desarrollar las pruebas unitarias para dicha estructura, teniendo en cuenta los siguientes escenarios y casos de prueba:  
<br/><br/>**Configuración de los Escenarios:**

| **Nombre** | **Clase** | **Escenario** |
| --- | --- | --- |
| setupStage1 | LinkedList | Un objeto LinkedList sin Nodos agregados |
| --- | --- | --- |
| setupStage2 | LinkedList | Un objeto LinkedList con un único nodo agregado, con id = ‘A0’ |
| --- | --- | --- |
| setupStage3 | LinkedList | Un objeto LinkedList con tres nodos agregados, con ids = ‘A0’, ‘A1’, ‘A2’ respectivamente |
| --- | --- | --- |

**Diseño de Casos de Prueba:**

| **Objetivo de la Prueba:** Verifica el método de agregar |     |     |     |     |
| --- |     |     |     |     | --- | --- | --- | --- |
| **Clase** | **Método** | **Escenario** | **Valores de Entrada** | **Resultado** |
| --- | --- | --- | --- | --- |
| LinkedList | addNode | setupStage1 | id = ‘A0’ | Se agrega un nuevo nodo a la lista, el primer elemento de la lista deja de ser null |
| --- | --- | --- | --- | --- |
| LinkedList | addNode | setupStage2 | id = ‘A4’ | Se agrega un Nuevo Elemento a la lista, el último elemento de la lista tiene el id = ‘A4’ |
| --- | --- | --- | --- | --- |

| **Objetivo de la Prueba:** Verifica el método buscar |     |     |     |     |
| --- |     |     |     |     | --- | --- | --- | --- |
| **Clase** | **Método** | **Escenario** | **Valores de Entrada** | **Resultado** |
| --- | --- | --- | --- | --- |
| LinkedList | search | setupStage1 | id = ‘A0’ | El método retorna un null |
| --- | --- | --- | --- | --- |
| LinkedList | search | setupStage2 | id = ‘A0’ | El método retorna un Nodo, con el id = ‘A0’ |
| --- | --- | --- | --- | --- |
| LinkedList | search | setupStage2 | id = ‘A2’ | El método retorna un null |
| --- | --- | --- | --- | --- |
| LinkedList | search | setupStage3 | id = ‘A2’ | El método retorna un Nodo, con el id = ‘A2’ |
| --- | --- | --- | --- | --- |

| **Objetivo de la Prueba:** Verifica el método remove |     |     |     |     |
| --- |     |     |     |     | --- | --- | --- | --- |
| **Clase** | **Método** | **Escenario** | **Valores de Entrada** | **Resultado** |
| --- | --- | --- | --- | --- |
| LinkedList | remove | setupStage2 | id = ‘A0’ | El primer elemento de la lista pasa a ser null |
| --- | --- | --- | --- | --- |
| LinkedList | remove | setupStage3 | id = ‘A0’ | El primer elemento de la lista pasa a ser el Nodo con el id = ‘A1’ |
| --- | --- | --- | --- | --- |
| LinkedList | remove | setupStage3 | id = ‘A2’ | El último elemento de la lista pasa a ser el Nodo con el id = ‘A1’ |
| --- | --- | --- | --- | --- |

**En la carpeta src del proyecto base, encontrará la carpeta _test/java_ donde deberá desarrollar las pruebas**