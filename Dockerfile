FROM anapsix/alpine-java

COPY build/libs/financial-loan-account-0.1.0.jar financial-loan-account-0.1.0.jar

ENTRYPOINT ["java", "-jar", "financial-loan-account-0.1.0.jar"]
CMD [""]
