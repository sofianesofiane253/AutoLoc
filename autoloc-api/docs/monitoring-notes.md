# AutoLoc — Notes sur le monitoring

## 1. Architecture

L'application AutoLoc utilise Prometheus et Grafana pour surveiller l'API Spring Boot.

- **Spring Boot Actuator :** expose l'état et les métriques de l'application.
- **Prometheus :** collecte les métriques toutes les 5 secondes.
- **Grafana :** affiche les métriques sous forme de graphiques.

Architecture :

Spring Boot → Prometheus → Grafana

## 2. Métriques sélectionnées

### 1. JVM Memory Used
```promql
jvm_memory_used_bytes
```
Mesure la mémoire utilisée par la JVM.

### 2. CPU Usage
```promql
process_cpu_usage
```
Mesure l'utilisation du processeur par l'application Spring Boot.

### 3. HTTP Request Rate
```promql
sum(rate(http_server_requests_seconds_count[1m]))
```
Mesure le nombre de requêtes HTTP par seconde.

### 4. HTTP Response Time p95
```promql
histogram_quantile(0.95, sum by (le) (rate(http_server_requests_seconds_bucket[5m])))
```
Mesure le temps de réponse du 95e percentile des requêtes HTTP.

### 5. Live Threads
```promql
jvm_threads_live_threads
```
Mesure le nombre de threads actifs de la JVM.

## 3. Problème résolu

**Problème :** le graphique HTTP Response Time p95 n'affichait aucune donnée, car les histogrammes HTTP n'étaient pas activés.

**Solution :** ajout de la propriété suivante dans `application.properties` :

```properties
management.metrics.distribution.percentiles-histogram.http.server.requests=true
```

Après le redémarrage de Spring Boot, les métriques histogrammes sont devenues disponibles et le graphique p95 a fonctionné.

## 4. Génération du trafic

Postman a été utilisé pour envoyer plusieurs requêtes vers :

- `/api/public/ping`
- `/api/hello`

Le graphique HTTP Request Rate a augmenté après l'envoi des requêtes, confirmant le fonctionnement du monitoring.