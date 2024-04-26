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

![](https://www.plantuml.com/plantuml/png/bP4zQWGn38Lxdq9rO2_WQeka3kJd01fRsIXuh47MJ1Fsxj7WpU90jjZ2yDwppFUGZyrGRPrB2AbWQ_0yVP7n9jy1eCeyAKLuDULwye1p1Av69r9tcLfINX9B7MQKaimBrOOHNgxQBtPPo31BX4ca45PFptx2BnGEX_5DhpGa_vOoNcIm6nRH6vr3E8-i1tX39UoOhdU2N2PQl6x3qxMjgBo7xrrvza7f4oCyef6xX4uHPHpe3lnBVDgecboGtTp7lBdViKm77wbc_zeV)