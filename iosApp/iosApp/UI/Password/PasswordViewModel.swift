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
    
    @Published var passwords: [Password] = []
    @Published var title: String = ""
    @Published var username: String = ""
    @Published var password: String = ""
    @Published var url: String = ""
    @Published var appLogo: String = ""
    @Published var searchTerm: String = "" {
        didSet(oldValue) {
            if (searchTerm != oldValue) {
                filterPasswordList()
            }
        }
    }

    private let passwordRepository: PasswordRepository = PasswordMemoryRepository()
    
    init() {
        updatePasswordList()
    }
    
    func updatePasswordList() {
        self.passwords = getPasswords()
    }

    func getPasswords() -> [Password] {
        return passwordRepository.getPasswords()
    }
    
    private func filterPasswordList() {
        self.passwords = getPasswords().filter{ password in
            searchTerm.isEmpty || password.title.lowercased().contains(searchTerm.lowercased())
        }
    }
    
    func onSave() {
        savePassword()
        resetFields()
        updatePasswordList()
    }
    
    private func savePassword() {
        passwordRepository.savePassword(
            title: title,
            username: username,
            password: password,
            url: url,
            appLogo: appLogo
        )
    }
    
    private func resetFields() {
        title = ""
        username = ""
        password = ""
        url = ""
        appLogo = ""
    }
}
