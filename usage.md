Sample Image Creation:
```
curl --location --request POST 'localhost:8080/image?objectDetection=true' \
--header 'Content-Type: application/json' \
--data-raw '{
    "imageUrl":"https://www.prestigeanimalhospital.com/sites/default/files/styles/large/public/golden-retriever-dog-breed-info.jpg",
    "objectDetection":true,
    "name": "dog"
a
```


## Build for Docker
`./gradlew bootJar`

## Setup
- Add your API details to application-local.properties, or copy docker-compose.env.template to .env
- 
