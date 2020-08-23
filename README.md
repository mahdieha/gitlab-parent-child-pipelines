# Gitlab parent-child pipelines

Gitlab parent-child pipeline is a convenient method for multi-module projects.

This is an example for the Java-Spring Boot project.

## Benefits

1. Child pipelines are easily adjustable.
2. Child pipelines to have its own configuration, which helps to better understand.
3. Child pipelines work easily with Gitlab CI/CD features for exmaple you can group the similar stages.

## Examples

1. Create a parent YAML file called .gitlab-ci.yml at the root of the project.


```yml
#parent gitlab-ci

stages:
- trigger-modules

trigger module 1/2:
  stage: trigger-modules
  trigger:
    include: module-one/gitlab-module-one.yml
  only:
    changes:
    - module-one/*

trigger module 2/2:
  stage: trigger-modules
  trigger:
    include: module-two/gitlab-module-two.yml
  only:
    changes:
    - module-two/*
```

2. Create a child YAML file with the desired name for example gitlab-ci-module-one at the root of the each module.

```yml
#child gitlab-ci

image: maven:latest

stages:
- build-package-maven

build-package maven 1/2:
  stage: build-package-maven
  script:
  - mvn compile
  only:
  - master

build-package maven 2/2:
  stage: build-package-maven
  script:
  - mvn clean package
  only:
  - master
```

## Usage

```parent pipeline
trigger module 1/2:
  stage: trigger-modules
  trigger:
    include: module-one/gitlab-module-one.yml
  only:
    changes:
    - module-one/*
````
1. **trigger module 1/2**: we can group the steps for better readability. In this example we have two steps. For example, the number 2 is the total number of steps, and 1 means the first step.

2. **include**: path/to/module.yml
3. **only: changes:** this pipeline will trigger when the module changes.

## Result

After the files are transferred to the Gitlab CE server, the Gitlab-Runner will run and the result will be as shown below.

![alt text](https://i.ibb.co/VS7Yr1z/Screen-Shot-2020-08-23-at-10-58-46-PM.png)