import {Student} from "../student";
import {Intake} from "../intake";
import {Degree} from "../degree";
import {Faculty} from "../faculty";

export class Registration {
  registrationId: string;
  student: Student;
  degree: Degree=new Degree();
  intake: Intake;
  date: string;
}
