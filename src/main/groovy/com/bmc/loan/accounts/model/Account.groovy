package com.bmc.loan.accounts.model

import io.swagger.annotations.ApiModelProperty

import com.fasterxml.jackson.annotation.JsonProperty
class Account  {
    private String name = null
    private String number = null
    
    Account(String name, String number) {
        this.name = name
        this.number = number
    }

    /**
     **/
    @ApiModelProperty(value = '')
    @JsonProperty('name')
    String getName() {
        return name
    }
    void setName(String name) {
        this.name = name
    }

    /**
     **/
    @ApiModelProperty(value = '')
    @JsonProperty('number')
    String getNumber() {
        return number
    }
    void setNumber(String number) {
        this.number = number
    }


    @Override
    boolean equals(Object o) {
        if (this == o) {
            return true
        }
        if (o == null || getClass() != o.getClass()) {
            return false
        }
        Account account = (Account) o
        return Objects.equals(name, account.name) &&
                Objects.equals(number, account.number)
    }

    @Override
    int hashCode() {
        return Objects.hash(name, number)
    }

    @Override
    String toString()  {
        StringBuilder sb = new StringBuilder()
        sb.append('class Account {\n')

        sb.append('  name: ').append(name).append('\n')
        sb.append('  number: ').append(number).append('\n')
        sb.append('}\n')
        return sb.toString()
    }
}
