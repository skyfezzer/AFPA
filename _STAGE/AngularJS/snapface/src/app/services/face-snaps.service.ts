import { Injectable } from "@angular/core";
import { FaceSnap } from "../models/face-snap.models";

@Injectable({
    providedIn: 'root'
})
export class FaceSnapService {
    faceSnaps: FaceSnap[] = [
        {
            id: 1,
            title: 'Archibald',
            description: 'Mon meilleur ami depuis tout petit !',
            imageUrl: 'https://cdn.pixabay.com/photo/2015/05/31/16/03/teddy-bear-792273_1280.jpg',
            createdDate: new Date(),
            likes: 0,
            location: 'Paris'
        },
        {
            id: 2,
            title: 'Three Rock Mountain',
            description: 'Un endroit magnifique pour les randonnées.',
            imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Three_Rock_Mountain_Southern_Tor.jpg/2880px-Three_Rock_Mountain_Southern_Tor.jpg',
            createdDate: new Date(),
            likes: 10,
            location: 'la montagne'
        },
        {
            id: 3,
            title: 'Un bon repas',
            description: 'Mmmh que c\'est bon !',
            imageUrl: 'https://wtop.com/wp-content/uploads/2020/06/HEALTHYFRESH.jpg',
            createdDate: new Date(),
            likes: 20
        }
    ];
    getAllFaceSnaps(): FaceSnap[]{
        return this.faceSnaps;
    }

    getFaceSnapById(faceSnapId: number): FaceSnap {
        const faceSnap = this.faceSnaps.find(faceSnap => faceSnap.id === faceSnapId);
        if(faceSnap){
            return faceSnap;
        }else{
            throw new Error('FaceSnap not found');
        }
    }

    likeFaceSnapById(faceSnapId: number, likeType: 'like' | 'unlike'): void {
        if(likeType === 'like'){
            this.getFaceSnapById(faceSnapId).likes++;
        }else if(likeType === 'unlike'){
            this.getFaceSnapById(faceSnapId).likes--;
        }else{
            throw new Error('Invalid like type');
        }
    }

}