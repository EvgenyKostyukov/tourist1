package server.entity;

import javax.persistence.*;

@Entity
    @Table(name="City")
    public class City {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "city")
        private String city;
        @Column(name = "info")
        private String info;


        public City() {
        }


        public City(String city, String info) {
            this.city = city;
            this.info = info;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String nameCities) {
            this.city = nameCities;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String referenceInformation) {
            this.info = referenceInformation;
        }


        @Override
        public String toString() {
            return "Cities{" +
                    "id=" + id +
                    ", nameCities='" + city + '\'' +
                    ", referenceInformation='" + info + '\'' +
                    '}';
        }
    }



