# TallerERP - Monorepo

Sistema de gestión empresarial desarrollado como monorepo con arquitectura de microservicios.

## Estructura del Proyecto

```
TallerERP/
├── backend/          # Java 21 + Spring Boot + Maven
├── frontend/         # React + Vite + Tailwind CSS
├── ai-proxy/         # Servicio proxy para AI (Bun)
└── docker-compose.yml
```

## Tecnologías

### Backend
- Java 21
- Spring Boot 3.2.0
- Maven
- PostgreSQL
- JPA/Hibernate

### Frontend
- React 18
- Vite 5
- Tailwind CSS 3
- React Router

### AI Proxy
- Bun Runtime

## Requisitos Previos

- Docker y Docker Compose instalados
- Java 21 (para desarrollo local del backend)
- Node.js 20+ (para desarrollo local del frontend)
- Bun (para desarrollo local del ai-proxy)

## Desarrollo Local

### Backend
```bash
cd backend
mvn spring-boot:run
```

El backend estará disponible en `http://localhost:8080`

### Frontend
```bash
cd frontend
npm install
npm run dev
```

El frontend estará disponible en `http://localhost:3000`

### AI Proxy
```bash
cd ai-proxy
bun install
bun run dev
```

El ai-proxy estará disponible en `http://localhost:3001`

## Configuración de Variables de Entorno

Antes de ejecutar el proyecto, crea un archivo `.env` en la raíz del proyecto con las siguientes variables:

```env
# Database Configuration (Neon o PostgreSQL)
DB_URL=jdbc:postgresql://your-database-host/database?sslmode=require
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

**Nota:** El archivo `.env` está en `.gitignore` y no se subirá al repositorio. Asegúrate de configurar tus propias credenciales.

## Docker

Para ejecutar todos los servicios con Docker:

1. Crea el archivo `.env` con tus credenciales de base de datos
2. Ejecuta:

```bash
docker-compose up -d
```

Esto iniciará:
- PostgreSQL en el puerto 5432 (si usas el servicio local)
- Backend en el puerto 8080
- Frontend en el puerto 80
- AI Proxy en el puerto 3001

Para detener los servicios:

```bash
docker-compose down
```

Para reconstruir las imágenes:

```bash
docker-compose up -d --build
```

## Estructura MVC del Backend

```
backend/src/main/java/com/tallererp/
├── controller/    # Controladores REST
├── service/       # Lógica de negocio
├── repository/    # Acceso a datos (JPA)
├── entity/        # Entidades JPA
└── dto/           # Data Transfer Objects
```

## Licencia

Proyecto privado - TallerERP

