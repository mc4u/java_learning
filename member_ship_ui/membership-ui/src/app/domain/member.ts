export class Member {
  name: string;
  emailId: string;
  password: string;
  orgId: number;

  constructor(name: string, emailId: string, password: string, orgId: number) {
    this.name = name;
    this.emailId = emailId;
    this.password = password;
    this.orgId = orgId;
  }
}
