# 🧠 Ad Keyword Targeting Backend (Spring Boot)

This is the backend API for the Ad Keyword Targeting platform — a full-stack project that allows users to create and search advertisements using keyword tagging and image uploads.

## 🚀 Live Backend URL

**Base URL:**  
🔗 [https://adapi-backend.onrender.com/api](https://adapi-backend.onrender.com/api)

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3+
- MySQL (hosted on Railway)
- RESTful APIs
- Multipart File Upload
- CORS support for frontend integration

---

## 📂 Project Structure
```bash
src/
└── main/
├── java/
│ └── com.example.adapi/
│ ├── controller/
│ ├── service/
│ └── model/
└── resources/
├── application.properties
└── static/uploads/
```

---

## 🔧 Setup & Run Locally

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/adapi-backend.git
   cd adapi-backend
   ```
    Add your application.properties:
```bash
spring.datasource.url=jdbc:mysql://your-db-host:port/dbname
spring.datasource.username=your-user
spring.datasource.password=your-pass
```

Run the app:

    ./mvnw spring-boot:run

📬 API Endpoints
🔹 Create Ad

POST /api/ads
Body (form-data):

    title

    description

    keywords (comma-separated)

    image (optional)

🔹 Search Ads

GET /api/ads/search?keyword=yourKeyword
🌐 CORS Support

CORS is enabled for:

    http://localhost:3000

    https://your-vercel-app.vercel.app

🖼 Sample Response

{
  "id": 1,
  "title": "iPhone 14 Pro Max",
  "description": "Like new, great condition",
  "keywords": ["iPhone", "Apple", "Mobile"],
  "imageUrl": "https://adapi-backend.onrender.com/uploads/iphone.jpg"
}

🧑‍💻 Author

    Archit Kumar
