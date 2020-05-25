package i;

public class Customer {

	private int age;

	private String address;

	public class Builder {

		public Builder setAddress(String address) {
			Customer.this.address = address;
			return this;
		}

		public Builder setAge(int age) {
			Customer.this.age = age;
			return this;
		}

		Customer build() {
			return Customer.this;
		}
	}
}