# proyecto-java-celiaaguileraa
proyecto-java-celiaaguileraa created by GitHub Classroom
Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: Celia Aguilera Camino
uvus:celagucam


ESTRUCTURAS DE LAS CARPETAS DEL PROYECTO
/src: Directorio con el código fuente.
fp.perros: Paquete que contiene los tipos del proyecto.
fp.perros_test: Paquete que contiene las clases de test del proyecto.
fp.utiles: Paquete que contiene las clases de utilidad.
fp.common: Paquete que contiene las clases auxiliares.
/data: Contiene el dataset del proyecto.
Dogs.csv: Archivo csv que contiene datos de diferentes perros adoptables.

ESTRUCTURA DEL DATASET

 El dataset usado en este proyecto tiene 11 columnas, 10 se han tomado del dataset original, y una, el peso del perro, se han generado de forma aleatoria. A continuación se describen las 11 columnas del dataset:

id: de tipo integer, indica el numero identificativo del perro.
name: de tipo cadena, indica el nombre del perro.
age: de tipo integer, indica la edad del perro en años de perro.
sex: de tipo cadena, indica el sexo del perro.
breed: de tipo lista, indica la raza o mezcla de razas del perro.
date_found: de tipo fecha, indica la fecha en la que se encontró el perro.
adoptable_from: de tipo fecha, indica la fecha a partir de la cual es posible adoptar al perro encontrado.
coat: de tipo cadena, indica el pelaje del perro.
size: de tipo cadena, indica el tamaño del perro.
neutered: de tipo boolean. Indica si el perro esta castrado o no.
weight: de tipo double. Indica el peso del perro.

TIPOS IMPLEMENTADOS:

Hemos creado un tipo base 'Perro' con su correspondiente tipo test. Una Factoria denominada 'FactoriaPerros' con su tipo test 'TestFactoriaPerros', el cual lee el csv Dogs.csv. Además de un contenedor 'Perros' y un Record 'PerroRecord'

Tipo Base - Partida
Representa los datos de un perro adoptable, están definidos métodos como getters y setters, equals, hashcode, compareTo, una propiedad derivada, una representación como cadena, constructores. A continuación detallo las propiedades del objeto:

id, de tipo integer, consultable. Indica el numero identificativo del perro.
name, de tipo cadena, consultable. Indica el nombre del perro.
age, de tipo integer, consultable.Indica la edad del perro en años de perro.
sex, de tipo Genero, consultable. Indica el sexo del perro, MALE, FEMALE.
breed, de tipo List<String>, consultable. Indica la raza o mezcla de razas del perro.
date_found, de tipo fecha, consultable. Indica la fecha en la que se encontró el perro.
adoptable_from, de tipo fecha, consultable. Indica la fecha a partir de la cual es posible adoptar al perro encontrado.
coat, de tipo Pelaje, consultable. Indica el pelaje del perro, pudiendo ser SHORT, MEDIUM, LONG, WIREHAIRED
size, de tipo Tamaño, consultable. Indica el tamaño del perro, pudiendo ser SMALL, MEDIUM, LARGE
neutered, de tipo boolean, consultable. Indica el peso del perro.

CONSTRUCTORES:

C1:Perro(Integer id, String name, Integer age, Genero sex, List<String> breed, LocalDate date_found, LocalDate adoptable_from, Pelaje coat, Tamaño size, Boolean neutered, Double weight): Crea un objeto con todas las propiedades básicas.
C2: Perro(Integer id,  String name, Integer age, Genero sex): Crea un objeto de tipo Perro con el id, nombre, edad y genero.

RESTRICCIONES:

R1: El perro no puede tener menos de 1 año.
R2: El peso no puede ser superior a 50 kilos.

CRITERIO DE ORDENACION: Primero se compara el id y posteriormente se compara con el nombre.

OTRAS OPERACIONES:

Integer getAnyo(): Devuelve cuantos años lleva el perro esperando a ser adoptado.

TIPOS AUXILIARES:
Hemos creado un tipo auxiliar llamado PerroRecord.

FACTORIA
El proyecto tiene una clase denominada FactoriaPerros la cual se encarga de parsear los datos del csv y leerlos(parsearPerros y leerPerros).
LeerPerros(String rutaFichero):Lee el csv que pasemos como parametro.
ParsearPerros(String linea): Lee cada linea del csv y parsean cada propiedad a su tipo correspondiente.
ParsearBooleano(String cadena):Para poder parsear la propiedad de tipo Boolean de cada linea del csv.
ParsearLista(String s):Para parsear la lista de caracteres de cada linea del csv.

TIPO CONTENEDOR
 Creamos Perros, siendo este el contenedor donde se almacenan objetos de tipo Perro, en esta clase están definidos los métodos hashcode, equals, toString, además de presentar otros que permiten añadir elementos, saber el tamaño de la lista o eliminar un elemento de ella.
 Presenta a su vez una serie de tratamientos secuenciales que detallaremos a continuación:

Constructores:
-C1: Perros()
-C2: Perros(Collection<Perro>perros)


Otras operaciones:
- getNumeroPerros():Obtiene el numero de elementos del contenedor.
- addPerro(Perro p): añade un elemento de tipo Perro al contenedor.
- addPerros(Collection<Perro> p):Agrega una lista de perros al contenedor.
- removePerro(Perro p):elimina un perro del contenedor.
- existeIdPerro(Integer id): Determina si existe un perro que tenga el id dado.
- getMediaPesoSegunTamaño(Tamaño size): Calcula la media de peso según el tamaño que se establezca.
- filtraPorPerrosCastrados():Filtra los perros que estén castrados.
- getListaPorPeso():Filtra por su peso y le otorga el perro que lo posee.
- getNumeroPerrosPorRaza():Determina el numero de perros que hay de cada raza.
- existeStream(Integer id):Determina si existe un perro que tenga el id dado utilizando el método Stream.
- getMediaPesoSegunTamañoStream(Tamaño size): Calcula la media de peso según el tamaño que se establezca utilizando el método Stream.
- filtraPorPerrosCastradosStream():Filtra los perros que estén castrados utilizando el método Stream.
- getPerroPequeñoMaxPesoStream(Tamaño t):Obtiene el mayor peso de un perro de tamaño determinado(pequeño) utilizando el método Stream.
- getPerrosMachosCastradosOrdenadoFechaEncontrados():Obtiene los perros de genero masculino que están castrados y los ordena segun la fecha en la que fueron encontrados utilizando el metodo Stream.
- getNumeroPerrosPorRazaStream(): Calcula el numero de perros que hay de cada raza utilizando el metodo Stream.
- getPesoPorTamaño():Determina los diferentes pesos de los perros según su tamaño utilizando un Stream.
- getMaxPesoPorTamaño():Determina el mayor valor de los pesos de los perros según su tamaño utilizando un Stream.
- getPerrosMenorPesoPorSexo(Integer n):Determina los n menores pesos de los perros según su género utilizando un Stream.
- MenorPesoPorSexo():Determina el genero del perro con menor peso utilizando un Stream.
