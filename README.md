# demo-deploy

## Commands to build image local

eval $(minikube docker-env)
docker build -t "demodeploy/demo" .

## Test image local

docker run -p 8080:8080 demodeploy/demo

## Create the deployment.yml file

kubectl create deployment demo --image=demodeploy/demo --dry-run -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip demo --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml

## Appyl deployment

kubectl apply -f deployment.yaml

## Utils

kubectl get all
kubectl delete deployment demo
kubectl delete service demo
kubectl port-forward service/demo 8080:8080