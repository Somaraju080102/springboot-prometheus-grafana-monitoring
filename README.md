# 🚀 Spring Boot Application Monitoring with Prometheus & Grafana

This project demonstrates how to **monitor a Spring Boot application** using **Prometheus** and **Grafana**.  
It collects application metrics such as **CPU usage, memory, request counts, and JVM stats** through Spring Boot Actuator and visualizes them using Grafana dashboards — all in real time.

---

## 🧩 Tech Stack

- **Spring Boot** (Actuator + Micrometer)
- **Prometheus** (Metrics scraping & storage)
- **Grafana** (Metrics visualization)
- **Docker** (Containerized Prometheus & Grafana setup)
- **PostgreSQL** *(optional if your app uses a database)*

---

## 🏗️ Architecture Overview

  <img width="1024" height="1000" alt="image" src="https://github.com/user-attachments/assets/fc7bac5d-8a4e-41d4-abdc-74e05c5efaa5" />


---

## ⚙️ Configuration

### 🧠 `application.properties`
  properties
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.metrics.tags.application=SpringBootApp



## 🧱 prometheus.yml

global:
  scrape_interval: 5s

scrape_configs:
  - job_name: 'spring-boot-app'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['192.168.0.105:8080']  # Replace with your host machine IP

## 🐳 Run Using Docker

## Step 1 — Start Prometheus

docker run -d \
  --name=prometheus \
  -p 9090:9090 \
  -v /opt/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml \
  prom/prometheus

## Step 2 — Start Grafana

docker run -d \
  --name=grafana \
  -p 3000:3000 \
  grafana/grafana

## Step 3 — Connect Grafana to Prometheus

  Open Grafana → http://localhost:3000

Default login: admin / admin

Go to Settings → Data Sources → Add data source

Choose Prometheus

Set URL to http://prometheus:9090 (if both are in same Docker network)

Click Save & Test

      


