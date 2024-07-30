//
//  PasswordViewModdel.swift
//  iosApp
//
//  Created by Christian Gomes on 08/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

class PasswordViewModel: ObservableObject {
    
    @Published var title: String = ""
    @Published var username: String = ""
    @Published var password: String = ""
    @Published var url: String = ""
    @Published var appLogo: String = ""
    
    private let passwordRepository: PasswordRepository = PasswordMemoryRepository()

    func getPasswords() -> [Password] {
        return passwordRepository.getPasswords()
    }
    
    func savePassword() {
        passwordRepository.savePassword(
            title: title,
            username: username,
            password: password,
            url: url,
            appLogo: appLogo
        )
        resetFields()
    }
    
    func resetFields() {
        title = ""
        username = ""
        password = ""
        url = ""
        appLogo = ""
    }
}
