import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Member} from '../domain/member';
import {Observable} from 'rxjs';
import {shareReplay} from 'rxjs/operators';

/*@Injectable({
  providedIn: 'root'
})*/
@Injectable()
export class ShareService {
  private URL = 'https://cloud4uapi-env.eba-bsu85v35.us-east-1.elasticbeanstalk.com/membership/api/registration';
  private LOGIN_URL = 'https://cloud4uapi-env.eba-bsu85v35.us-east-1.elasticbeanstalk.com/membership/api/login';
  constructor(private http: HttpClient) { }

  registration = (member: Member): Observable<Member> => {
    return this.http.post<Member>(this.URL, member)
      .pipe(
        shareReplay()
      );
  }

  login = (emailId: string, password: string): Observable<Member> => {
    this.LOGIN_URL = `${this.LOGIN_URL}/${emailId}/${password} `;
    console.log('Service', this.LOGIN_URL);
    return this.http.get<Member>(this.LOGIN_URL)
      .pipe(
        shareReplay()
      );
  }
}
