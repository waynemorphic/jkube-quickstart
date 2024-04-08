## JKube Quickstart

The demo uses JKube to deploy the sample Java application to Kubernetes using a single command
and without the boilerplate code required for setting up a Kubernetes deployment.

### Requirements
1. Java 21
2. Maven
3. Docker desktop
4. Minikube

### Getting Started
- Clone the repository
```shell
$ git clone git@github.com:waynemorphic/jkube-quickstart.git 
```
- Move to jkube-quickstart directory
```shell
$ cd jkube-quickstart
```

- Run the app with maven

```shell
$ mvn exec:java

INFO: Server started on port: 8081
```

- Hit the endpoint

```shell
$ curl http://localhost:8081/hello

Hello world
```

### Deploy Java App to Kubernetes
1. Start docker engine/docker desktop
2. Start minikube
```shell
$ minikube start
```
3. Deploy the Java App on Kubernetes
```shell
$ mvn clean install k8s:build k8s:resource k8s:apply
```
4. Configure your local environment to re-use the Docker daemon inside the Minikube instance.
```shell
$ eval $(minikube -p minikube docker-env)
```
5. Check logs of created pod
```shell
$ kubectl get pods

NAME                                READY   STATUS             RESTARTS        AGE
jkube-quickstart-7d8bf7688b-m6rw9   1/1     Running            0               28s
```
6. Hit the endpoint of the running Java app
```shell
$ kubectl get svc
NAME               TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
jkube-quickstart   NodePort    10.105.155.84   <none>        8081:30812/TCP   1m

$ curl `minikube ip`:30812/hello
Hello world
```