import { Component, OnInit, Input } from '@angular/core';
import { FaceSnap } from '../models/face-snap.models';
import { FaceSnapService } from '../services/face-snaps.service';

@Component({
  selector: 'app-face-snap',
  templateUrl: './face-snap.component.html',
  styleUrls: ['./face-snap.component.scss']
})
export class FaceSnapComponent implements OnInit {
  @Input() faceSnap!: FaceSnap;
  liked!: boolean;
  buttonText!: string;

  constructor(private faceSnapService: FaceSnapService) { }

  ngOnInit() {
    this.liked = false;
    this.buttonText = 'J\'aime';
  }

  onLike() {
    if (this.liked) {
      this.faceSnapService.likeFaceSnapById(this.faceSnap.id, 'unlike');
      this.liked = false;
      this.buttonText = 'J\'aime';
    } else {
      this.faceSnapService.likeFaceSnapById(this.faceSnap.id, 'like');
      this.liked = true;
      this.buttonText = 'J\'aime plus';
    }
  }
}
