# Diagrama de clases
@startuml

class Objetivo{
  nombre: String
  id: integer
  descripcion: String
  recompensa: Recompensa
  completado: boolean
  }
  
Objetivo -- Recompensa

class Recompensa{
  nombre: String
  tipo: String
  valor: String
  id: integer


}
Objetivo --* Tarea
class Tarea{
  objetivos: Objetivo
  usuarios: Usuario
  
}

Objetivo --* Evento
class Evento{
  objetivos: Objetivo
  usuarios: Usuario
  recompensa: Recompensa
  
}

@enduml

![](https://www.plantuml.com/plantuml/png/bP4zQWGn38Lxdq9rO2_WQflKWVmSG3CMYu976cJDD67l7WtUB0vaYnI6fy_oUq8-DqVpRQbfhjWQl4oVvBphLm8GNIQZ36zkB9S0N3AmE5t8eYhKPkDrPfMXnsZMPILfcE7rhkFYa9KSYsQOL2kX1Bt6IJ-XS3gDR_f80_bpAETLXtB7glPWvfIkOzOJlACHzfYkZmIzTRHytqRGhMreVC2FheA5tM-_vvt4zMROYtyvFjvUH9r9IdpKDm00)