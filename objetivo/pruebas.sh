#!/bin/bash

# Crear usuario
echo "Crear usuario"
curl -X POST http://localhost:8080/usuarios -H "Content-Type: application/json" -d '{"nombre":"Juan","email":"juan@example.com","contrasena":"secret"}'

# Listar usuarios
echo "Listar usuarios"
curl http://localhost:8080/usuarios

# Ver usuario por ID
echo "Ver usuario 1"
curl http://localhost:8080/usuarios/1

# Crear objetivo
echo "Crear objetivo"
curl -X POST http://localhost:8080/objetivos -H "Content-Type: application/json" -d '{"nombre":"Recorrer 1km","descripcion":"Lograr recorrer 1 km en 30 minutos","vencimiento":60}'

# Listar objetivos
echo "Listar objetivos"
curl http://localhost:8080/objetivos

# Obtener el ID del primer objetivo creado
OBJECTIVE_ID=$(curl -s http://localhost:8080/objetivos | jq -r '.[0].id')

# Asignar objetivo a usuario
echo "Asignar objetivo a usuario"
curl -X POST http://localhost:8080/usuarios/asignar-objetivo -H "Content-Type: application/json" -d "{\"usuarioId\":1,\"objetivoId\":\"$OBJECTIVE_ID\"}"

# Ver objetivos cumplidos por usuario
echo "Ver objetivos cumplidos por usuario 1"
curl http://localhost:8080/usuarios/1/objetivos-cumplidos

# Ver objetivos por cumplir por usuario
echo "Ver objetivos por cumplir por usuario 1"
curl http://localhost:8080/usuarios/1/objetivos-por-cumplir

# Crear recompensa
echo "Crear recompensa"
curl -X POST http://localhost:8080/recompensas -H "Content-Type: application/json" -d '{"nombre":"🚲 Bicicleta Pro Max","tipo":"Medalla","valor":"Alta"}'

# Crear recompensa 1
echo "Crear recompensa 1"
curl -X POST http://localhost:8080/recompensas -H "Content-Type: application/json" -d '{"nombre":"🥇 Medalla de oro","tipo":"Medalla","valor":"Alta"}'

# Crear recompensa 2
echo "Crear recompensa 2"
curl -X POST http://localhost:8080/recompensas -H "Content-Type: application/json" -d '{"nombre":"🥈 Medalla de plata","tipo":"Medalla","valor":"Media"}'

# Crear recompensa 3
echo "Crear recompensa 3"
curl -X POST http://localhost:8080/recompensas -H "Content-Type: application/json" -d '{"nombre":"🥉 Medalla de bronce","tipo":"Medalla","valor":"Baja"}'

# Listar recompensas
echo "Listar recompensas"
curl http://localhost:8080/recompensas

# Obtener el ID de la primera recompensa creada
REWARD_ID=$(curl -s http://localhost:8080/recompensas | jq -r '.[0].id')

# Asignar recompensa a objetivo
echo "Asignar recompensa a objetivo"
curl -X POST http://localhost:8080/recompensas/asignar -H "Content-Type: application/json" -d "{\"recompensaId\":\"$REWARD_ID\",\"objetivoId\":\"$OBJECTIVE_ID\"}"
