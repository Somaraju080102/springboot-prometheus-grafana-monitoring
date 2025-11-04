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
  +------------------------+
| Spring Boot App |
| (port: 8080) |
| /actuator/prometheus |
+-----------+------------+
|
| metrics scraped every 5s
v
+------------------------+
| Prometheus (9090) |
| - prometheus.yml |
| - stores time-series |
+-----------+------------+
|
| datasource connection
v
+------------------------+
| Grafana (3000) |
| - connected to Prom |
| - dashboards & alerts|
+------------------------+


