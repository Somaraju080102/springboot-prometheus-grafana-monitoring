🚀 Spring Boot Application Monitoring with Prometheus & Grafana

Monitor your Spring Boot application metrics (CPU, memory, request count, etc.) in real time using Prometheus and Grafana.
This project demonstrates how to expose application metrics via Spring Boot Actuator and visualize them through Grafana dashboards.

🧩 Tech Stack

Spring Boot (Actuator + Micrometer)

Prometheus (Metrics scraping)

Grafana (Visualization)

Docker (for Prometheus & Grafana setup)

PostgreSQL (optional if app connects to DB)

+------------------------+
|   Spring Boot App      |
|  (port: 8080)          |
|  /actuator/prometheus  |
+-----------+------------+
            |
            | metrics scraped every 5s
            v
+------------------------+
|   Prometheus (9090)    |
|   - prometheus.yml     |
|   - stores time-series |
+-----------+------------+
            |
            | datasource connection
            v
+------------------------+
|   Grafana (3000)       |
|   - connected to Prom  |
|   - dashboards & alerts|
+------------------------+

⚙️ Configuration

🧠 application.properties

management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.metrics.tags.application=SpringBootApp


🧱 prometheus.yml
global:
  scrape_interval: 5s

scrape_configs:
  - job_name: 'spring-boot-app'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['192.168.0.105:8080'] 


🐳 Run Using Docker
🧱 Step 1 — Start Prometheus
docker run -d \
  --name=prometheus \
  -p 9090:9090 \
  -v /opt/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml \
  prom/prometheus

🧱 Step 2 — Start Grafana
docker run -d \
  --name=grafana \
  -p 3000:3000 \
  grafana/grafana

🧱 Step 3 — Connect Grafana to Prometheus

Open Grafana → http://localhost:3000

(Default login: admin / admin)

Go to Settings → Data Sources → Add data source

Choose Prometheus

Set URL: http://prometheus:9090 (if same Docker network)

Click Save & Test

