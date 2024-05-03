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
  fecha: Date
  categoria: String
  
}

Objetivo --* Evento
class Evento{
  objetivos: Objetivo
  usuarios: Usuario
  recompensa: Recompensa
  fecha: Date
  
}

@enduml

![](https://www.plantuml.com/plantuml/png/TOzD2iD028NtSmela0lCAZSej2SmCn8i4msEpQRaxhNGdopQXV3UK_5px8xcjwMbqh1tE4rNSjxqdW14byaemyMDPOw0QmOMfvaiNALUZDV2AeSPewBBIj8nm_cZe_6KZHohPfXK6w54kaUbzr4OXkFE2-cR_8HoNlLWDsngVvXJsjD8KkFT1m00)