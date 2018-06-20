

<html>

    <head><link rel="alternate" type="text/xml" href="/WebService.asmx?disco" />

    <title>
	WebService Servicio Web
</title></head>

  <body>

    <div id="content">

      <p class="heading1">WebService</p><br>

      <span>
          <p class="intro">Web service crea link calendario</p>
      </span>

      <span>

          <p class="intro">Las operaciones siguientes son compatibles. Para una definición formal, revise la <a href="WebService.asmx?WSDL">descripción de servicios</a>. </p>
          
          
              <ul>
            
              <li>
                <a href="WebService.asmx?op=nuevoLink">nuevoLink</a>
                
                <span>
                  <br>Creación link de calendario
                </span>
              </li>
              <p>
            
              </ul>
            
      </span>

      
      

    <span>
        
    </span>
    
      <span>
          <hr>
          <h3>Este servicio Web utiliza http://tempuri.org/ como espacio de nombres predeterminado.</h3>
          <h3>Recomendación: cambiar el espacio de nombres predeterminado antes de hacer público el servicio Web XML.</h3>
          <p class="intro">Cada servicio Web XML necesita un espacio de nombres único para que las aplicaciones de cliente puedan distinguir este servicio de otros servicios del Web. http://tempuri.org/ está disponible para servicios Web XML que están en desarrollo, pero los servicios Web XML publicados deberían utilizar un espacio de nombres más permanente.</p>
          <p class="intro">Debe identificar su servicio Web XML con un espacio de nombres que controle. Por ejemplo, puede utilizar el nombre de dominio de Internet de su compañía como parte del espacio de nombres. aunque muchos espacios de nombres de servicios Web XML parecen direcciones URL, éstos no pueden señalar a recursos reales en el Web. (Los espacios de nombres de los servicios Web XML son los URI.)</p>
          <p class="intro">En los servicios Web XML que se crean con ASP.NET, se puede cambiar el espacio de nombres predeterminado utilizando la propiedad Namespace del atributo WebService. WebService es un atributo aplicado a la clase que contiene los métodos del servicio Web XML. A continuación se muestra un ejemplo de código que establece el espacio de nombres en "http://microsoft.com/webservices/":</p>
          <p class="intro">C#</p>
          <pre>[WebService(Namespace="http://microsoft.com/webservices/")]
public class MyWebService {
    // implementación
}</pre>
          <p class="intro">Visual Basic</p>
          <pre>&lt;WebService(Namespace:="http://microsoft.com/webservices/")&gt; Public Class MyWebService
    ' implementación
End Class</pre>

          <p class="intro">C++</p>
          <pre>[WebService(Namespace="http://microsoft.com/webservices/")]
public ref class MyWebService {
    // implementación
};</pre>
          <p class="intro">Para obtener más detalles acerca de espacios de nombres XML, vea la sugerencia W3C en <a href="http://www.w3.org/TR/REC-xml-names/"">Espacio de nombres en XML</A>.</p>
          <p class="intro">Para obtener más detalles acerca de WSDL, vea <a href="http://www.w3.org/TR/wsdl">Especificación WSDL</a>.</p>
          <p class="intro">Para obtener más detalles sobre los URI, vea <a href="http://www.ietf.org/rfc/rfc2396.txt">RFC 2396</a>.</p>
      </span>

      

    
  </body>
</html>
