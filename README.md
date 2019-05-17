# Proyecto Omega

Descargar el proyecto de https://github.com/andreamarin/ProyectoOmega. En este proyecto se encuentran las siguientes carpetas:

* **DataWebWizard: **Contiene el proyecto de NetBeans con la aplicación
* **databases: ** Las bases de datos con las que trabaja la aplicación

También está un archivo _.jar_ que contiene la librería de JSON que se utilizó en el proyecto y un archivo _status.txt_ que contiene el log de ejecución de la aplicación web.

## Desplegar aplicación

Para ejecutar el proyecto hay que abrirlo en NetBeans, hacer un _clean and build_ y después _deploy_. Posteriormente se da click en el botón _run_ para desplegar la página principal de la aplicación.

## Manual de usuario

La página principal del proyecto contiene los campos necesarios para crear un nuevo usuario. Se deben de llenar todos los campos y posteriormente dar click en el botón "Regístrate".

Si ya se tiene un usuario entonces se debe dar click en el botón _Cambiar a log in_ para que se desplieguen únicamente los campos de usuario y contraseña.

Si la operación es exitosa, el usuario será redirigido al menú principal. Si ocurre algún error se eliminan los campos y se vuelve a cargar la página.

###Menú Principal

En el menú principal el usuario puede elegir entre las siguientes operaciones:

* Agregar tabla a la base de datos
* Consultar tabla
* Interactuar con la tabla

En la parte superior aparece un drop-down list con las tablas actuales del usuario. Debe elegir la tabla con la que quiere trabajar de esta lista y posteriormente darle click a cualquiera de los tres botones.

 Si el usuario no tiene ninguna tabla, entonces los botones de consultar e interactuar se deshabilitan y la lista aparece vacía.

####Agregar tabla

Para agregar una tabla el usuario debe ingresar el nombre de la tabla y los campos de la misma.

Para cada campo se debe especificar.

* Nombre
* Tipo (varchar, int, boolean)
* Longitud (en caso de ser varchar)
* Si es llave primaria

La llave primaria de cada tabla está compuesta únicamente por un atributo y no se pueden crear relaciones entre tablas.

![](/Users/andreamarin/Desktop/Captura de pantalla 2019-05-16 a la(s) 18.50.10.png)

Para agregar campos se debe dar click en el botón "_agregar campo_" y una vez que se agregaron todos los campos deseados, se da click al botón _crear tabla_.

Si la operacion es exitosa, se eliminan los campos para crear la tabla y en la página únicamente queda el link para regresar al menú principal. Si ocurre un error, entonces aparece una alerta en la pantalla diciéndole al usuario que verifique su información.

####Consultar tabla

Primero se debe de elegir la tabla a consultar del drop-down list y posteriormente dar click en el botón _Consultar tabla_. Éste te redirige a una página donde el usuario puede elegir el número de registros que quiere ver.

Para ver los registros se debe dar click en el botón _Visualizar_, lo que desplegará los registros en la parte inferior de la página y se habilitan los botones para navegar a através de la tabla.

El botón "_<<_" muestra la primera página y el botón ">>" muestra la última. Si la tabla seleccionada no contiene registros aún, se muestra una leyenda en la página que lo indica.

![](/Users/andreamarin/Desktop/Captura de pantalla 2019-05-16 a la(s) 18.55.09.png)

Si se quiere cambiar el número de registros a visualizar, simplemente se ingresa el nuevo número en el text-box correspondiente y se da click en el botón visualizar nuevamente.

####Interactuar con tabla

En el menú principal se debe de elegir la tabla con la que se quiere trabajar y posteriormente dar click en el botón _Interactuar con tabla_. 

Esto te lleva a una página donde se muestran los campos que contiene la tabla junto con una leyenda que indica el tipo del campo y los valores aceptados. Asímismo, la primary key tiene la leyenda **PK** al inicio del campo.

![Página "Interactúa con tabla"](/Users/andreamarin/Desktop/Captura de pantalla 2019-05-16 a la(s) 18.51.55.png)

En esta página aparecen tres opciones:

* **Agregar registro: ** Se deben de llenar todos los campos.
* **Modificar registro:** Se debe de llenar la primary key del registro a modificar y el valor a modificar en los campos deseados. No es necesario llenar todos los campos, únicamente aquellos que se quieran modificar.
* **Eliminar registro: **Para realizar esta operación únicamente es necesario llenar la primary key del registro a eliminar.

Tras realizar la operación se mostrara una alerta con el resultado de la misma (exitoso/ocurrió un error).