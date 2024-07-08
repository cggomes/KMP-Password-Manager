//
//  AppDelegate.swift
//  iosApp
//
//  Created by Christian Gomes on 08/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import UIKit
import SDWebImageSVGCoder

class AppDelegate: NSObject, UIApplicationDelegate, ObservableObject {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        SDImageCodersManager.shared.addCoder(SDImageSVGCoder.shared)
        return true
    }
    
}
