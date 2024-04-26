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

@enduml

![](https://www.plantuml.com/plantuml/png/TP1BQiKm34NdMeN6XRS1ZzuE2lqiGB55KB6j8DkPbEozTaY31-t0S7MGEHSzIoMhBKK07waKV5s-kCgktu2ODIt63j-hILuxaE1GSkMLhK-1YpVPl6YUTeozferp8OTlTmR44IDN2kfmKOrCkTEZF_YLukCn_RagJUJFKbKsdSQTeje_dG6EsVM27sHCbsRaqw3NHd7tDJfjfP79W9zd6WmEW2Vdq5By0G00)