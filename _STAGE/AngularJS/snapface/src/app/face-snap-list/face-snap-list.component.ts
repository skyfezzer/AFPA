import { Component, OnInit } from '@angular/core';
import { FaceSnap } from '../models/face-snap.models';
import { FaceSnapService } from '../services/face-snaps.service';

@Component({
  selector: 'app-face-snap-list',
  templateUrl: './face-snap-list.component.html',
  styleUrls: ['./face-snap-list.component.scss']
})
export class FaceSnapListComponent implements OnInit {
  faceSnaps!: FaceSnap[];
  constructor(private faceSnapService: FaceSnapService) { }

  ngOnInit(): void {
    this.faceSnaps = this.faceSnapService.getAllFaceSnaps();
  }

}
