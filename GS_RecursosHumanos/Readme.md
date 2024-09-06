////////////////////////////////////////////////////

## Instalación

1. Clonar el repositorio
2. Ejecutar `mvn install` para instalar dependencias

## Configuración de Base de Datos

1. Ejecutar `schema.sql` para crear tablas
2. Ejecutar `data.sql` para poblar datos iniciales

## Ejecución

1. Ejecutar `mvn spring-boot:run` para iniciar la aplicación

## para docker 
docker build -t gs-recursos-humanos .
docker run -p 8080:8080 gs-recursos-humanos
