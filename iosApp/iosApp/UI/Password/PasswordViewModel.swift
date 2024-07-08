//
//  PasswordViewModdel.swift
//  iosApp
//
//  Created by Christian Gomes on 08/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

struct PasswordViewModel {
    
    private let passwordRepository: PasswordRepository = PasswordMemoryRepository()
    
    func getPasswords() -> [Password] {
        return passwordRepository.getPasswords()
    }
    
}
