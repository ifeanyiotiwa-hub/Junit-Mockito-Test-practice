package dev.betpawa.testing.classtotest;

import java.io.Serializable;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Address implements Serializable, Comparable<Address> {

    private static final Long serialVersionUID = 1L;
    private final String address1;
    private final String city;
    private final String state;
    private final String zip;


    private Address(Builder builder) {
        this.address1 = builder.address1;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
    }

    public String getAddress1() {
        return address1;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public int compareTo(Address that) {
        return ComparisonChain.start().compare(this.zip, that.zip)
                                      .compare(this.state, that.state)
                                      .compare(this.city, that.city)
                                      .compare(this.address1, that.address1)
                                      .result();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getAddress1(), this.getCity(), this.getState(), this.getAddress1());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final Address that = (Address) obj;

        return Objects.equal(this.address1, that.address1)
                && Objects.equal(this.city, that.city)
                && Objects.equal(this.state, that.state)
                && Objects.equal(this.zip, that.zip);
    }



    public static class Builder {
        private String address1;
        private String city;
        private String state;
        private String zip;


        public Address build() {
            return new Address(this);
        }

        public Builder address1(String address1) {
            this.address1 = address1;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }
    }

}
