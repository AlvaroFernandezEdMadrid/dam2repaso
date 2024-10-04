#!/bin/bash

# Verificar si se proporcionó un mensaje
if [ -z "$1" ]; then
  echo "Uso: $0 \"Mensaje de commit\""
  exit 1
fi

# Agregar todos los cambios
git add ./*

# Hacer commit con el mensaje proporcionado
git commit -m "$1"

