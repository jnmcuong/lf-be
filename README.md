#1 Setup with Java 17 and Postgres 16

#2 Test with get all
curl --header "user-id: 1" http://localhost:8080/tasks

#3 Test with create an todo task
curl -H "user-id: 1" -H "Content-Type: application/json"   --request POST   --data '{"name":"task_1","description":"Task 1", "estimation":"1"}'   http://localhost:8080/tasks