@SuiteLogin
Feature: Suite de pruebas iConstruye Usuario

  Background:
    Given estoy en la página de inicio de iConstruye

  @LOGIN-01 @Login @SmokeTest
  Scenario: TC-59596 Validar Login en IC
    When ingreso las credenciales de usuario "comprador"
    And selecciono el centro de gestión
    Then debo ver el icono de Mi Escritorio en la página principal de iConstruye

  @LOGIN-02 @Login @SmokeTest
  Scenario: TC-59901 Validar Logout en IC
    And estoy logueado como usuario "comprador"
    When cierro sesion en iConstruye
    Then debo ver la página de bienvenida de iConstruye

  @TC-72102 @Ignore #validar dato
  Scenario: TC-72102 Usuario comprador que accede con correo electrónico y contraseña (SSO)
    When ingreso las credenciales de usuario por correo "userCorreoSSO"
    And selecciono el centro de gestión
    Then debo ver el icono de Mi Escritorio en la página principal de iConstruye

  @TC-72371 #validar flujo
  Scenario: TC-72168 Usuario proveedor que accede con correo electrónico y contraseña y es redireccionado al New Marketplace
    When ingreso las credenciales de usuario por correo "correoSsoMKP"
    Then debo ver el pop up para actualizar datos en New Marketplace
    And debo ver la opción de Configuración

  @TC-72371 @Ignore #validar flujo
  Scenario: TC-72371 Usuario proveedor que accede con usuario organización y contraseña y es redireccionado al New Marketplace
    When ingreso las credenciales de usuario "usuarioSsoMKP"
    Then debo ver el pop up para actualizar datos en New Marketplace
    And debo ver la opción de Configuración

  @TC-72409 @Login
  Scenario: TC-72409 Validar que los usuarios puedan recuperar su contraseña para ambos accesos habilitados en el sitio. Ingreso con correo electrónico
    When selecciono la opción de olvidé mi contraseña
    And ingreso el correo de usuario "userCorreoSSO" para recuperar la contraseña
    Then debo ver la página de Cambio de Clave
    When regreso al login e ingreso las credenciales de usuario por correo "userCorreoSSO"
    Then debo ver el icono de Mi Escritorio en la página principal de iConstruye