#!/bin/bash

# Crear usuario
echo Crear usuario
http POST :8080/usuarios nombre=Juan email=juan@example.com contrasena=secret

# Listar usuarios
echo Listar usuarios
http :8080/usuarios

# Ver usuario por ID
echo Ver usuario 1
http :8080/usuarios/1

# Crear objetivo
echo Crear objetivo
http POST :8080/objetivos nombre="Recorrer 1km" descripcion="Lograr recorrer 1 km en 30 minutos" vencimiento=60

# Listar objetivos
echo Listar objetivos
http :8080/objetivos

# Asignar objetivo a usuario
echo Asignar objetivo a usuario
http POST :8080/usuarios/asignar-objetivo usuarioId=1 objetivoId=1

# Ver objetivos cumplidos por usuario
echo Ver objetivos cumplidos por usuario 1
http :8080/usuarios/1/objetivos-cumplidos

# Ver objetivos por cumplir por usuario
echo Ver objetivos por cumplir por usuario 1
http :8080/usuarios/1/objetivos-por-cumplir

# Crear recompensa
echo Crear recompensa
http POST :8080/recompensas nombre="Medalla de oro" tipo="Medalla" valor="Alta"

# Listar recompensas
echo Listar recompensas
http :8080/recompensas

# Asignar recompensa a objetivo
echo Asignar recompensa a objetivo
http POST :8080/recompensas/asignar recompensaId=1 objetivoId=1
