FROM anapsix/alpine-java

# galapagos-dev@bmc.com
MAINTAINER _2c4d9d@bmc.com

COPY build/libs/financial-loan-account-0.1.0.jar financial-loan-account-0.1.0.jar

ENTRYPOINT ["java", "-jar", "financial-loan-account-0.1.0.jar"]
CMD [""]