# Proyecto Java con Cucumber y Selenium



Este proyecto es una aplicación Java que usa Cucumber para la definición de pruebas y Selenium para interactuar con el navegador. 



## Requisitos



- Java 17
- Gradle



## Dependencias



- Selenium WebDriver
- Cucumber para Java y JUnit
- WebDriverManager
- JUnit Jupiter API y Engine
- Gson
- SLF4J API
- ExtentReports Cucumber7 Adapter
- ExtentReports
- JUnit Vintage Engine



## Cómo usar



Clone el repositorio y navegue hasta el directorio del proyecto. Desde la línea de comandos, ejecute:



```bash
gradle runWithCucumber -P tags=@TC-59596
```



Esto iniciará las pruebas Cucumber usando el escenario proporcionado. El escenario se define como sigue:



```gherkin
@TC-59596 @Login
Scenario: TC-59596 Validar Login en IC
When ingreso las credenciales de usuario "comprador"
And selecciono el centro de gestión
Then debo ver el icono de Mi Escritorio en la página principal de iConstruye
```



El escenario realiza un login a la pagina de Iconstruye

### Personalización de la ejecución 

Es posible personalizar el comando de ejecución indicando dos parametros adicionales al comando de ejecución llamados env y nav. Estos parametros se utilizan para especificar el entorno de ejecución y el navegador en el que se necesitan ejecutar las pruebas. 

Los entornos disponibles son "qa" y "prod"

Los navegadores disponibles son "Chrome", "Firefox" y "Edge"

En caso de no querer añadir esto paremetros adicionales, existen valores por defecto para esto parametros son "env=qa" y "nav=Chrome"

Para utilizar los parametros adicionales siga el siguiente ejemplo:

```bash
gradle runWithCucumber -P tags=@TC-59596 -P nav="Edge" -P env="prod"
```

## Reportes



Los resultados de las pruebas se almacenarán en el directorio `results` en formato JSON, HTML y PDF. Además de generar un reporte de allure que podrá ser integrado al pipeline de ejecución.



## Tags de Cucumber



Los tags de Cucumber se utilizan para organizar los features y escenarios. En este proyecto, el tag `@TC-59596` indicado en el comando de ejecución es solo un ejemplo de como marcar un escenario de prueba. Ya que estos se pueden marcar de forma particular y unica indicando el numero de caso o mediante tags generales compartidos entre los escenarios, de esta manera es posible ejecutar multiples escenarios con un solo tag. 

Los escenarios marcados con `@Ignore` se excluirán de la ejecución de las pruebas.



## Notas adicionales



Este proyecto utiliza el plugin Java de Gradle y se ha probado con la versión 1.0 del mismo. Para más información sobre las dependencias y las tareas de Gradle, consulte el archivo `build.gradle`.
## Cómo contribuir



Si desea contribuir a este proyecto, aquí hay algunos pasos para comenzar:



1. Clone este repositorio.
2. Crea una nueva rama.
3. Realice los cambios o agregue funciones.
4. Ejecute las pruebas para asegurarse de que todas pasen.
5. Envíe una solicitud de extracción con una descripción detallada de los cambios.



Cualquier contribución que haga será muy apreciada. Si tiene alguna pregunta o problema, no dude en abrir un problema en este repositorio.



## Configuración de Gradle



La configuración de Gradle para este proyecto es manejada a través del archivo `build.gradle`. Este archivo define las tareas que se pueden ejecutar, así como las dependencias del proyecto.



La versión de Java utilizada por este proyecto se define a través de la propiedad `sourceCompatibility`. También se definen las dependencias necesarias para ejecutar las pruebas y compilar el proyecto.



La propiedad `tags` se usa para definir qué etiquetas de Cucumber deben incluirse en la ejecución de las pruebas. Si no se define, todas las pruebas se ejecutarán, excepto las que estén marcadas con `@Ignore`.



## Ajustes de las tareas



Existen dos tareas definidas en el `build.gradle`: `runWithCucumber` Esta tarea inicia las pruebas con Cucumber.



Para ejecutar estas tareas, use el comando `gradle` seguido del nombre de la tarea. Por ejemplo, para ejecutar las pruebas con Cucumber, use el comando `gradle runWithCucumber`.



Si necesita agregar más tareas a este proyecto, puede hacerlo agregándolas al archivo `build.gradle`.



## Versionado



Este proyecto sigue el esquema de versionado semántico. Las versiones se indican en el archivo `build.gradle` bajo la propiedad `version`.



## Licencia



Este proyecto está licenciado bajo los términos de la licencia MIT. Para más detalles, consulte el archivo `LICENSE`.



## Contacto



Si tiene alguna pregunta o problema relacionado con este proyecto, no dude en ponerse en contacto con nosotros. Estaremos encantados de ayudarle.