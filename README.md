# Examen Final - Programación Avanzada I
### Ing. y Lic. en Sistemas
### Turno Julio 2026

### Objetivos
- Desarrollar endpoints que permitan el registro y consulta de la entidad Empleado

### Tiempo
- 2 horas reloj

### Evaluación
- Se evaluará la versión del proyecto en el repositorio correspondiente, a la hora de finalización del examen, estimada para el día 30/07/2026 17:00
- El proyecto debe compilar sin errores en cualquier entorno de programación en el que se abra
- Todos los test unitarios deben pasar en verde

### Punto de partida
- Se proveerá el esquema de Backend en blanco, donde el alumno tendrá que crear test y código fuente que cubra la consigna.
- Prestar atención a los comentarios en el código

## Consigna
#### Módulo Recursos Humanos
_Se desea implementar un backend para un microservicio que permita registrar empleados._

#### Restricciones:
- No pueden existir dos Empleados con el mismo legajo
- El id debe ser un UUID generado por la lógica de dominio, y no por estrategia de base de datos
- Todos los atributos de Empleado son obligatorios
- La fecha de ingreso del empleado no puede ser superior a la actual
- El puesto del empleado debe ser uno de los siguientes valores: ANALISTA - SUPERVISOR - GERENTE
- El legajo debe cumplir el formato: 3 letras mayúsculas seguidas de 4 números (ej. `ABC1234`)
- El salario debe ser mayor a 0, y además debe respetar el mínimo según el puesto:
  - ANALISTA: mínimo 500.000
  - SUPERVISOR: mínimo 800.000
  - GERENTE: mínimo 1.200.000

#### Funcionalidad
- Crear Empleado
  - Endpoint: POST http://localhost:8080/empleados
  - RequestBody:
    ```json
    {
      "id": "7e8ad860-716d-4b86-9643-430870caefe7",
      "nombre": "Juan Pérez",
      "legajo": "ABC1234",
      "fecha_ingreso": "2022-03-01T00:00:00.000Z",
      "puesto": "SUPERVISOR",
      "salario": 850000
    }
    ```

- Buscar Empleados
  - Endpoint: GET http://localhost:8080/empleados

- Buscar Empleado por legajo
  - Endpoint: GET http://localhost:8080/empleados/{legajo}
  - Si el empleado no existe, debe lanzarse una excepción personalizada (`EmpleadoNoEncontradoException`) que resulte en una respuesta 404

#### Buenas prácticas y conceptos a considerar
- La nomenclatura de paquetes será en minúsculas
- La nomenclatura de clases será en UpperCamelCase
- La nomenclatura de métodos será en lowerCamelCase
- La organización de paquetes será por modelo->aspecto, tanto a nivel src/main como a nivel src/test. Ejemplo:
  ```
  empleados
  └─ excepciones
  └─ modelo
  └─ repositorio
  └─ casodeuso
  ```
- Usar Excepciones personalizadas
- Se debe usar método factory/instancia para crear objetos
- Nomenclatura representativa de clases, métodos, etc.
