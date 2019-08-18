package Wayfair;

public class Interview {

  public String histogramString(String input) {
    char c = input.charAt(0);
    int count = 0;
    StringBuilder sb = new StringBuilder();
    for(int i=1; i<input.length(); i++) {
      if(c == input.charAt(i)) {
        count++;
      }
      else {
        sb.append(c);
        if(count > 0) {
          sb.append(count);
        }
        c = input.charAt(i);
        count = 0;  
      }
    }
    // last char is not checked
    sb.append(c);
    if(count > 0) {
      sb.append(count);
    }
    return sb.toString();
  }
}


// select d.name, case when sum(e.salary) is null then 0 else sum(e.salary) end
// from employee e
// right join departments d on e.department_id = d.id
// group by e.department_id, d.name