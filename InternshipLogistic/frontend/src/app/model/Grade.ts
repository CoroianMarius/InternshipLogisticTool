export class Grade
{
  email:string;
  mentor:string;
  task:string;
  grade:bigint;
  comment:string;
  constructor(email:string,mentor:string,task:string,grade:bigint,comment:string)
  {
    this.email=email;
    this.mentor=email;
    this.task=mentor;
    this.grade=grade;
    this.comment=comment;

  }
}
