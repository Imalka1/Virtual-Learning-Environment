export class LoginStatus {
  static accountType: string;

  static getLoginStatus(): number {
    this.accountType = localStorage.getItem('accountType');
    if (this.accountType == "admin") {
      return 1;
    } else if (this.accountType == "student") {
      return 2;
    } else if (this.accountType == "lecturer") {
      return 3;
    } else if (this.accountType == "locked") {
      return 4;
    } else {
      return 5;
    }
  }
}
