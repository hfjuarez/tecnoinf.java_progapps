# README

### Casos de uso:

1.  Alta instituto 
2.  Alta usuario 
3.  Modificar usuario 
4.  Alta curso 
5.  Alta edición de un Curso 
6.  Crear programa formación 
7.  Agregar curso programa formación 
8.  Inscripción edición de Curso 
9.  Consulta edición de Curso 
10.  Consulta de Programa de Formación 
11.  Consulta de Curso 
12.  Consulta Usuario  

*A su vez se necesitan funciones complementarias para realizar los casos de uso. Ejemplo: Lista de cursos, entre otras.*

---

# Package: API
Contiene la interfaz, factory y la clase "CargarDatosPrueba". Permitiendo conectar la parte Swing, y cualquier otro "programa" así poder establecer una comunicación con la logica.

**Clases:**

* BizcochoEnARG (factory)
	Requiera la clase LControlador (logica.controladores.LControlador).
* ILogica (Interfaz)
* CargarDatosPrueba (carga los valores predeterminados)

---

# Package: logica

Contiene toda la lógica para el funcionamiento del mismo.
El mismo se subdivide en diferentes sub package que comprenden una parte de especifica del programa. 

**Lista de sub packages:**
*En orden alfabético*

* logica.controladores
* logica.cursos
* logica.edicioncursos
* logica.entidades
* logica.formaciones
* logica.institutos
* logica.usuarios

## logica.controladores
Contiene, como su nombre lo menciona los controladores y/o manejadores necesarios para cumplir con los requerimientos y/o solicitudes.

**Listas de Clases:**

* 

 