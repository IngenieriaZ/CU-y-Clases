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

![](https://www.plantuml.com/plantuml/png/TL112W8n3Bpd5Vd0Vg2d_O6WB-YsOOcqoPB6lSZ-tGegHVGGc9aCmoHpysX-gmKWbTWQdfOhEUzw1qJHkXW5lBYnh5tW7935QINhB5DBnbjYbS5ZbBHk92q6F7zmNpnX8OzP0owgXQ9qTIT9N9d4TSncuSHVrgCFlFlXD0tnh_Q3yhE_ywO3tMDH-tCUm04ma-J-cmS0)