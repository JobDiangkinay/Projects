export class Person {
    id: Number;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    email: string;

    constructor(id: Number,firstName: string,lastName: string,phoneNumber: string,email: string){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}